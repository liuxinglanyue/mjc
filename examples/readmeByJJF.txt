../mjc Foo.java
../mjc Foo.java -g > Foo.dot
sed -i '$d' Foo.dot
dot Foo.dot -Tpng -o Foo.png
