.SUFFICES: .java .class

SOURCEDIR := '.'
SOURCES := $(shell find $(SOURCEDIR) -name '*.java')
ARGS=-encoding ISO-8859-1

JC=javac
RM=rm

%.class:
	$(JC) $(ARGS) $*.java

all: classes

classes: $(SOURCES:.java=.class)

clean:
	$(RM) -f *.class *~

