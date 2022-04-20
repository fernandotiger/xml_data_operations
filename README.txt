I have used Maven for lib manangement.
The operation type (attrib and sub) I could create a class or Map to represent it inside city but I decided to keep as an city class attribute to make it simple
I spend around 4 hours to complete the test, 1.5 + 1.5 + 1 hours divided in 3 different days.
In my opinion the challenge task is appropriated for candidates.

To convert the operations from the xml file I have used Factory and to handle the operations I adapted Command

To run it on your IDE just need to import it as Maven project


Problem to be solved
Create a dynamical data processing that will receive an input file as data and operation and writes the result in an output file.
All files are XML format. A schema is provided only through the sample files.
The input data has a simple format: the file contains a top-level element called “data”, below it, there are entries called “city” which have a variable count of attributes and child nodes. In our example, each city has two attributes and one child node. An attribute called “name” is always present and is used for filtering.
The operation file is built in a similar way: there is a top-level element called “operations”, below there are “operation” elements, each one with the following attributes:

name: the name of the operation, also for the output
attrib: name of the attribute or child node to be evaluated
type: specify if attrib refers to an attribute or a child node
func: the function to be evaluated, could be min, max, sum, or average.
filter: a regular expression to be used with the name attribute of the city element. Only such cities should be included in the evaluation.

The resulting file consists of a top-level element „results“, below there are “result” elements. Each result has a name attribute that is identical to the name of the corresponding operation.
The text result of each result element is the result of the operation.
The solution should be developed for the Java VM. You can use all standard libraries provided by your language of choice. The input/output file names can be hardcoded.
Decimal numbers should have a precision of two decimal places.

Files included
Delivered are:

data.xml - sample input data file
operations.xml – Sample for operations to be calculated
output.xml – The result for the  delivered sample files
