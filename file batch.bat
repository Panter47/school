
@echo off 

CLS 

echo creo la cartella appunti 
md \users\tchen\desktop\appunti 

echo creo la cartella tep, sistemi e informatica dentro appunti 
md \users\tchen\desktop\appunti\tep
md \users\tchen\desktop\appunti\sistemi
md \users\tchen\desktop\appunti\informatica 

echo creo le cartelle c,c++,c#,HTML e CSS dentro la cartella informatica 
md\users\tchen\desktop\appunti\informatica\C
md \users\tchen\desktop\appunti\informatica\C++
md \users\tchen\desktop\appunti\informatica\C#
md \users\tchen\desktop\appunti\informatica\HTML
md \users\tchen\desktop\appunti\informatica\CSS

echo creo un file txt con dentro scritto dir 
copy con \users\tchen\desktop\appunti\tep\helps
dir

echo creo un file txt con dentro i percorso della cartella appunti 
copy con \users\tchen\desktop\appunti\sistemi\contenuto
tree \users\tchen\desktop\appunti
 