@echo off
IF '%1'=='' GOTO USAGE
IF '%2'=='-n' GOTO TEST
FOR /R %1 %%F IN ("*.jar") DO call packjars1.bat "%%~dpnF"
GOTO END
:TEST
FOR /R %1 %%F IN ("*.jar") DO echo "%%~dpnxF"
GOTO END
:USAGE
ECHO Usage: PACKJARS folder
:END
