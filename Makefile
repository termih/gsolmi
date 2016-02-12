
JFLAGS= -g
JC=javac
JVM=java
SRCS=Gsolmi.java ScorePanel.java Keypanel.java SettingsPanel.java Sound.java Docpanel.java
PROG=Gsolmi
CLASSPATH=../class
JAR=jar
MANIFEST=manifest.mf
JARFLAGS=cvfm
BIN=../bin
RM=rm -f
 
all:
	$(JC) -Xlint:all -d $(CLASSPATH) $(SRCS)

run: $(SRCS)
	$(JVM) -cp ..:$(CLASSPATH) $(PROG)

clean:
	$(RM) $(CLASSPATH)/*.class
	$(RM) $(BIN)/*.jar
	$(RM) *.class

jar:
	$(JAR) $(JARFLAGS) $(BIN)/$(PROG).jar $(MANIFEST) -C $(CLASSPATH) .
	$(JAR) -uvf $(BIN)/$(PROG).jar ../images/gSolmiIcon_32x32.png
