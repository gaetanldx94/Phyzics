#!/bin/bash

cd ..

# Définir les chemins
src_dir="src"
bin_dir="bin"
exe_dir="exe"

# Créer le dossier de destination s'il n'existe pas
mkdir -p "$bin_dir"
mkdir -p "$exe_dir"

# Compiler les projets
for project_dir in "$src_dir"/*; do
	if [ -d "$project_dir" ]; then
		project_name=$(basename "$project_dir")
		project_bin_dir="$bin_dir/$project_name"

		echo "Compilation de $project_name..."
		javac "$src_dir/$project_name"/*.java -d "$project_bin_dir"

		# Créer un fichier manifest
		echo "Main-Class: Main" > "$bin_dir/META-INF/MANIFEST.MF"

		# Créer le fichier JAR
		jar -cvfm "$exe_dir/$project_name.jar" "$bin_dir/META-INF/MANIFEST.MF" -C "$project_bin_dir" .
	fi
done