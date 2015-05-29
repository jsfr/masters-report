# ----------------------------------------------------------------------
#
# File:        Makefile
# 
# Description: Makefile for plane Steiner minimum tree programs
#
# Date:        Feb 6, 1997
#
# Author(s):   Martin Zachariasen, DIKU
# 
# ----------------------------------------------------------------------

# Configure your C++ compiler
CC = g++
OPTFLAGS = -O3 -Wall
#OPTFLAGS = -O3 -pg -Wall

# Configure LEDA, that is, specify directory where installed
LEDAROOT = /usr/local/projects/disk02/algorithm/LEDA-4.1-Linux

# The program can either use a combined X-Windows and command line
# interface or a X-Windows "free" interface (all arguments given on
# command line, i.e. for batch runs). You may want to experiment with
# X-Windows version before going to the batch version.
# Uncomment one of the following two lines to select interface:
INTERFACE = XWINDOWS
#INTERFACE = BATCH

# Give a description of the machine used
MACHINE = "Linux"

# Local search class library
LSDIR = ../../project/ls

# You should not need to change anything below here ...
# ----------------------------------------------------------------------

LIBS_XWINDOWS = -lW -lX11
LIBS_BATCH    =
LIBS = -L/usr/X11R6/lib -L/usr/local/lib -L$(LEDAROOT) $(LIBS_$(INTERFACE)) -lP -lG -lL -lm

IFLAGS  = -I$(LEDAROOT)/incl -I$(LSDIR)

CFLAGS_XWINDOWS = -DXWINDOWS 
CFLAGS_BATCH    =
CFLAGS = $(OPTFLAGS) $(CFLAGS_$(INTERFACE)) -DMACHDESC='$(MACHINE)'

OBJECTS = 

PROGS   = geosteiner96 fst_prune 

.c.o:
	$(CC) $(CFLAGS) $(DFLAGS) $(IFLAGS) -c $*.c

.o:
	$(CC) $(CFLAGS) -o $* $*.o $(OBJECTS) $(LIBS)

.c:
	$(CC) $(CFLAGS) $(DFLAGS) $(IFLAGS) -c $*.c
	$(CC) $(CFLAGS) -o $* $*.o $(OBJECTS) $(LIBS)

all: $(PROGS)

geosteiner96: geosteiner96.o fst_generation.o fst_rect_generation.o fst_concatenation.o $(OBJECTS)
	$(CC) $(CFLAGS) -o geosteiner96 \
	geosteiner96.o fst_generation.o fst_rect_generation.o fst_concatenation.o \
        $(OBJECTS) $(LIBS)

fst_prune: fst_prune.o fst_concatenation.o $(OBJECTS)
	$(CC) $(CFLAGS) -o fst_prune \
	fst_prune.o fst_concatenation.o \
        $(OBJECTS) $(LIBS)

greedy: greedy.o $(OBJECTS)
	$(CC) $(CFLAGS) -o greedy \
	greedy.o \
        $(OBJECTS) $(LIBS)

lsfst:  ls lsfst.o $(OBJECTS)
	$(CC) $(CFLAGS) -o lsfst1 \
	lsfst.o \
        $(OBJECTS) $(LIBS)

testrect: testrect.o $(OBJECTS)
	$(CC) $(CFLAGS) -o testrect \
	testrect.o \
        $(OBJECTS) $(LIBS)

testgraph: testgraph.o steiner_graph.o
	$(CC) $(CFLAGS) -o testgraph \
	testgraph.o steiner_graph.o $(LIBS)

ls:
	(cd $(LSDIR); make)

clean:
	rm -f *.o $(PROGS) core

misc_proc.o : misc_proc.c misc_proc.h

dyn_partition.o : dyn_partition.c dyn_partition.h

symm_bool_matrix.o : symm_bool_matrix.c symm_bool_matrix.h

graph_proc.o : graph_proc.c graph_proc.h misc_proc.h

rect_proc.o : rect_proc.c rect_proc.h graph_proc.h misc_proc.h

steiner_proc.o : steiner_proc.c steiner_proc.h misc_proc.h

point_generation_proc.o : point_generation_proc.c point_generation_proc.h \
                          steiner_proc.h misc_proc.h

bsd_matrix.o : bsd_matrix.c bsd_matrix.h steiner_proc.h misc_proc.h

steiner_heuristics_proc.o : steiner_heuristics_proc.c steiner_heuristics_proc.h \
                            steiner_proc.h misc_proc.h 

greedy_heuristics.o : greedy_heuristics.c greedy_heuristics.h \
                      steiner_proc.h misc_proc.h rect_proc.h

fst_generation.o : fst_generation.c fst_generation.h \
                   steiner_heuristics_proc.h steiner_proc.h misc_proc.h

fst_rect_generation.o : fst_rect_generation.c fst_rect_generation.h \
                        steiner_heuristics_proc.h steiner_proc.h misc_proc.h

fst_concatenation.o : fst_concatenation.c fst_concatenation.h greedy_heuristics.h \
                      steiner_heuristics_proc.h steiner_proc.h misc_proc.h

lsfst.o : lsfst.c $(LSDIR)/LS.h $(LSDIR)/LS.c

