grammar Lang;
NUMBER:[0-9]+('.'[0-9]*)?|'.'[0-9]+;
WHITESPACE:[ \n\r\t]+ ->skip;
ADD:'+';
SUB:'-';
MUL:'*';
DIV:'/';
FUNC_DEC:'func';
IF: 'if';
END: 'end';
NAME:[A-Za-z][A-Za-z0-9]*;

vars:var1=NAME?(','var+=NAME)*;
function:FUNC_DEC(name=NAME)'('v=vars'):'(st+=statement)*'return'(ret=expr)';';
func_call:n=NAME'('e1=expr?(','exs+=expr)*')';
if_block:IF'('var=NAME(eq='=='|more='>'|less='<')expr')'(st+=statement)*END';';


expr:left=add(op+=('+'|'-')right+=add)*;
add:left=mul(op+=('*'|'/')right+=mul)*;
mul:(neg='-')?(num = NUMBER|'('expr')'|fun=func_call|var=NAME);
assignment:(var=NAME)op=':='(ex=expr);
statement:(assign = assignment|func = func_call|if=if_block)';';
program:(f+=function)|(st+=statement)+;
