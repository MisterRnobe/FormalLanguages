grammar Lang;
NUMBER:[0-9]+('.'[0-9]*)?|'.'[0-9]+;
WHITESPACE:[ \n\r\t]+ ->skip;
ADD:'+';
SUB:'-';
MUL:'*';
DIV:'/';
MOD: '%';
FUNC_DEC:'func';
IF: 'if';
ELSE: 'else';
END: 'end';
WHILE: 'while';
NAME:[A-Za-z][A-Za-z0-9]*;

vars:var1=NAME?(','var+=NAME)*;
function:FUNC_DEC(name=NAME)'('v=vars')'':'(st+=statement)*'return'(ret=expr)';';
func_call:n=NAME'('e1=expr?(','exs+=expr)*')';
condition: '('left=expr(t=('=='|'>'|'<'))right=expr')'':';
if_block:IF(cond=condition)(if_st+=statement)+END(';'ELSE(else_st += statement)+END)?;
while_block:WHILE(cond = condition)(st+=statement)+END;

expr:left=add(op+=('+'|'-')right+=add)*;
add:(left=mul)(op+=(MUL|DIV|MOD)right+=mul)*;
mul:(neg='-')?(num = NUMBER|'('expr')'|fun=func_call|var=NAME);
assignment:(var=NAME)op=':='(ex=expr);
statement:(assign = assignment|func = func_call|ifbl=if_block|whbl=while_block)';';
program:(f+=function)*(st+=statement)+;
