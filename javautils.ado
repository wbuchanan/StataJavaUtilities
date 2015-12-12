// Drop program from memory of previously loaded
cap prog drop javautils

// Define program
prog def javautils

	// Set version for Stata interpretation
	version 13.1

	// Set program syntax
	syntax [, URL UPDate(string asis) MAVen ] 

	// Local macro with repository root
	glo javautilsrepo `"https://github.com/wbuchanan/StataJavaUtilities"'

	// Local macro with location of the pom file
	loc pom "https://raw.githubusercontent.com/wbuchanan/StataJavaUtilities/master/pom.xml"

	// Check maven option
	if `"`maven'"' != "" {

        // Preserve current state of memory
        preserve

            // Load part of the POM file from the repository
            infix 8 firstlineoffile str pom 1-2044 using `"`pom'"', clear

            // Keep first four observations
            qui: keep in 1/4

            // Remove XML tags from the values
            qui: replace pom = regexs(2) if ///
            regexm(pom, "(<[a-zA-Z].*>)([a-zA-Z0-9].*)(</[a-zA-Z].*>)")

            // Local for groupId parameter
            loc groupid "-DgroupId=`: di pom[1]' "

            // Local for artifactId parameter
            loc artifactid "-DartifactId=`: di pom[2]' "

            // Local for version parameter
            loc version "-Dversion=`: di pom[3]' "

            // Local for packaging parameter
            loc packaging "-Dpackaging=`: di pom[4]' "

        // Restore original state of memory
        restore

	} // End IF Block for Maven option

	// If URL option selected display the location of the source code repository
	if `"`url'"' != "" {

		// Print hyperlink to the GitHub repo
		di as res `"{browse "${javautilsrepo}":source code repository}"'

	} // End IF Block to print the location of the source code repository

	// If Update option is specified
	if `"`update'"' != "" {

	    // Build string with names of files to install
	    checkinstall `update'

        // Store the return macros locally in this program
        loc dl `r(toupdate)'
        loc rep `r(toreplace)'

	    // Loop over the return values
	    forv i = 1/`: word count "`rep'"' {

	        // Copy the file from GitHub
	        qui: copy `: word `i' of "`dl'"' `"`: word `i' of "`rep'"'"', replace

	        // If Maven option specified, install into the user's local Maven
	        // repo
	        if `"`maven'"' != "" & `"`c(os)'"' != "Windows" {

	            // Shell out and install the jar in the maven repo
	            ! mvn install:install-file -Dfile="`: word `i' of ""`rep'"'" ///
	            `groupid' `artifactid' `version' `packaging'

	        } // End IF Block for maven option

	    } // End Loop over updates

	} // End IF Block for update handling

// End of the program
end


// Define subroutine for processing arguments for installation
prog def checkinstall, rclass

    syntax anything(name=toinst id="Need something to install")

    // Compiled java libraries
    loc classes "tree/master/target/StataJavaUtilities.jar"

    // Compiled javadoc for the library
    loc javadocs "tree/master/target/StataJavaUtilities-javadoc.jar"

    // Compiled source code library
    loc src "tree/master/target/StataJavaUtilities-sources.jar"

    loc classesdl `"https://github.com/wbuchanan/StataJavaUtilities/`classes'"'
    loc javadocdl `"https://github.com/wbuchanan/StataJavaUtilities/`javadocs'"'
    loc srcdl `"https://github.com/wbuchanan/StataJavaUtilities/`src'"'

    // Work around for copy issue
    if `"`c(os)'"' == "MacOSX" {
        loc personal "/Users/`c(username)'/Library/Application Support/Stata/ado/personal/"
    }
    else if `"`c(os)'"' == "Windows" loc personal "C:/ado/personal/"
    else loc personal "`c(sysdir_personal)'"

    loc classesfile `"`personal'StataJavaUtilities.jar"'
    loc javadocfile `"`personal'StataJavaUtilities-javadoc.jar"'
    loc srcfile `"`personal'StataJavaUtilities-sources.jar"'

    // Check for update all
    if inlist("all", `"`: subinstr loc toinst `" "' `", "', all'"')  {

        // Set the download macro
        loc dl "`classesdl'" "`javadocdl'" "`srcdl'"

        // Set the macro with the corresponding names to be replace
        loc rep "`classesfile'" "`javadocfile'" "`srcfile'"

    } // End IF Block for update all

    // If user doesn't specify the all option
    else {

        // Loop over the words if all not specified
        forv i = 1/`: word count `toinst'' {

            // Check for valid entry
            if inlist(`"`: word `i' of `toinst''"', "classes", "javadoc", "src") {

                // Add to the download macro
                loc dl `dl' ``"``: word `i' of `toinst''dl'"'

                // Add to the replacement macro
                loc rep `rep' `"``: word `i' of `toinst''file'"'

            } // End IF Block

            // For invalid options
            else {

                // Print error message to console
                di in yellow `"Ignored: `: word `i' of `toinst'' is not a valid option."'

            } // End ELSE Block for invalid options

        } // End Loop over the passed arguments

    } // End ELSE Block for other options

    // Return the macro with each of the URLS
    ret loc toupdate `dl'

    // Return the replacement macro
    ret loc toreplace `rep'

// End of subroutine
end


