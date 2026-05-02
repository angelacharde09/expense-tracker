# Build and Run script for Expense Tracker

$BIN_DIR = "bin"
$SRC_DIR = "src"
$MAIN_CLASS = "ExpenseTrackerGUI"

# Create bin directory if it doesn't exist
if (!(Test-Path $BIN_DIR)) {
    New-Item -ItemType Directory -Path $BIN_DIR | Out-Null
}

# Compile source files
Write-Host "Compiling..." -ForegroundColor Cyan
javac -d $BIN_DIR (Get-ChildItem -Path $SRC_DIR -Filter *.java -Recurse).FullName

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful. Running $MAIN_CLASS..." -ForegroundColor Green
    java -cp $BIN_DIR $MAIN_CLASS
} else {
    Write-Host "Compilation failed." -ForegroundColor Red
}
