# define name of installer
name "Masumi"
outFile "pkg\masumi-win32-installer.exe"

RequestExecutionLevel admin

Function .onInit
# TODO Check UserInfo to make sure the user has the correct rights to install
FunctionEnd

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

    # Set the context to All users so that the uninstall will get rid of
    # the links
    SetShellVarContext all

    # set the installation directory as the destination 
    # for the following actions
    setOutPath $INSTDIR

    # specify a file to go in the ouput path
    file "pkg\masumi.exe"

    # create the uninstaller
    writeUninstaller "$INSTDIR\uninstall-masumi.exe"

    # Create registry keys so that the uninstaller shows up in
    # Add/Remove Programs
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Masumi" \
        "DisplayName" "Masumi - A Japanese language learning tool."
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Masumi" \
        "UninstallString" "$\"$INSTDIR\uninstall-masumi.exe$\""
    WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Masumi" \
        "QuietUninstallString" "$\"$INSTDIR\uninstall-masumi.exe$\" /S"

    # create a shortcut named "new shortcut" in the 
    # start menu programs directory
    createShortCut "$SMPROGRAMS\masumi.lnk" "$INSTDIR\masumi.exe"
    # Add a link to the desktop
    createShortCut "$DESKTOP\masumi.lnk" "$INSTDIR\masumi.exe"
sectionEnd

# uninstaller section start
section "uninstall"

    # Set the context to All users so that the uninstall will get rid of
    # the links
    SetShellVarContext all

    delete "$INSTDIR\masumi.exe"
    delete "$INSTDIR\uninstall-masumi.exe"

    delete "$SMPROGRAMS\masumi.lnk"
    delete "$DESKTOP\masumi.lnk"

    DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Masumi"

    rmdir "$INSTDIR"
    # uninstaller section end
sectionEnd
