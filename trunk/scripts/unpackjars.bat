@echo off
IF '%1'=='' GOTO USAGE
IF '%2'=='-n' GOTO TEST
FOR /R %1 %%F IN ("*.pack") DO call unpackjars1.bat "%%~dpnF"
GOTO END
:TEST
FOR /R %1 %%F IN ("*.pack") DO echo "%%~dpnxF"
GOTO END
:USAGE
ECHO Usage: PACKJAVA folder
:END
