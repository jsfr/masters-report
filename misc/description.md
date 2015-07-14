# Project Description
The objective of the project will first and foremost be to implement Smiths
algorithm for finding Steiner Minimal Trees in Euclidean d-Space efficiently. In
the original paper by Smith the proposed C implementation has a lot of
double work and ineffiecency and thus it is the main objective of this project
to implement this algorithm effiecently and then benchmark this against the
original implementation.

A secondary objective of the project will be to explore and propose possible
improvements to the algorithm. Some of which might be explored are:

* Sorting the terminals in  different orders before finding the positions.
* Analytically solving the problem with fewer (3) terminals at a time to improve
  limits where the Steiner points may move very slowly normally.
* An analysis of the stop-criteria used by Smith to see whether this is actually
  correct, and whether there are possible improvements.

If there is time the project will also look at versions of the problem such as
the fixed-orientation version, where edges are only allowed to have certain
predefined orientations.

The learning goals of the project are:

* Understanding, analysing and describing complex algorithms and solutions to a
  specific problem area
    - In this case the problem of finding Steiner Minimal Trees
      in Euclidean d-Space using Smiths algorithm)
* On the basis of the analysis propose possible improvements to the existing
  solution, implement and test the improvements.
* Benchmarking

# Table of Contents
* Abstract
* Introduction
* Notation / Definitions
* Important Concepts (MST, FST, SMT, etc.)
* Smiths Algorithm
* Possible Improvements
* Effecient Implementation
* Benchmarks / Tests
* Conclusion
* References

# Project Schedule
* 09/03/15: Read and understand Smiths article and C implementation
* 23/03/15: Analyse and identify double work in Smiths implementation
* 30/03/15: Start implementing effecient version of Smiths algorithm (in C and/or Go)
* 13/04/15: Research analytically solving with 3 terminals
* 20/04/15: Implement using with 3 terminals
* 04/05/15: Research sorting the terminals
* 11/05/15: Implement sorting terminals
* 25/05/15: Research stop-criteria to check whether this is actually correct
* 01/06/16: If possible suggest and implement improvements to stop-criteria
* 22/06/15: Finish implementation of effecient version (Both with and without possible
improvements)
* 20/07/15: Finish report
* 20/07/15-01/09/15: Buffer

NB: When finished with a task I should also write the corresponding part of the report.
