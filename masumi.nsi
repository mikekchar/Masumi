# define name of installer
name "Masumi"
outFile "pkg\masumi-win32-installer.exe"

# These are the pages that are shown on install
Page directory
Page instfiles

# These are the pages that are shown on uninstall
UninstPage uninstConfirm
UninstPage instfiles

# define installation directory
installDir $PROGRAMFILES\Masumi

# start default section
section "Masumi"

    # set the installation directory as the destination 
    # for the following actions
    setOutPath $INSTDIR

    # specify a file to go in the ouput path
    file "pkg\masumi.exe"

    # create the uninstaller
    writeUninstaller "$INSTDIR\uninstall-masumi.exe"

    # create a shortcut named "new shortcut" in the 
    # start menu programs directory
    # point the new shortcut at the program uninstaller
    createShortCut "$SMPROGRAMS\uninstall-masumi.lnk" "$INSTDIR\uninstall-masumi.exe"
    createShortCut "$SMPROGRAMS\masumi.lnk" "$INSTDIR\masumi.exe"
sectionEnd

# uninstaller section start
section "uninstall"

    delete "$INSTDIR\masumi.exe"
    delete "$INSTDIR\uninstall-masumi.exe"

    delete "$SMPROGRAMS\masumi.lnk"
    delete "$SMPROGRAMS\uninstall-masumi.lnk"

    rmdir "$INSTDIR"
    # uninstaller section end
sectionEnd
