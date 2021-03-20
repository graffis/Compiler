LIB_ANTLR := lib/antlr-4.8-complete.jar
ANTLR_SCRIPT := MicroC.g4
SRC_DIRS := src/ast/*.java src/ast/visitor/*.java src/compiler/*.java src/assembly/*.java src/assembly/instructions/*.java

all: compiler

compiler:
	rm -rf build
	mkdir build
	java -cp $(LIB_ANTLR) org.antlr.v4.Tool -o build/compiler $(ANTLR_SCRIPT)
	javac -cp $(LIB_ANTLR) -d classes $(SRC_DIRS) build/compiler/*.java

clean:
	rm -rf classes build

cool:
	rm -rf classes build
	rm -rf build
	mkdir build
	java -cp $(LIB_ANTLR) org.antlr.v4.Tool -o build/compiler $(ANTLR_SCRIPT)
	javac -cp $(LIB_ANTLR) -d classes $(SRC_DIRS) build/compiler/*.java

	./runme tests/test0.uC out0
	python3 RiscSim/driver.py out0

	./runme tests/test1.uC out1
	python3 RiscSim/driver.py out1

	./runme tests/test2.uC out2
	python3 RiscSim/driver.py out2

	./runme tests/test3.uC out3
	python3 RiscSim/driver.py out3

	./runme tests/test4.uC out4
	python3 RiscSim/driver.py out4




	# ./runme tests/test7.uC out7
	# python3 RiscSim/driver.py out7



	