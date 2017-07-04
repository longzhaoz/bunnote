/**
 * Created by longz on 17-7-2.
 */
////////////////////////////
// code 外加 pre
// 代码中间有空行无法正确 parse
///////////////////////////
var rst = markdown.toHTML($('#new-post-content').val()), mcode = new RegExp(/<code>([a-zA-Z]+)?([^<>]*(\r?\n|\r))+<\/code>/,'gu'), curM = 1;
while(curM !== null){
    // mcode不加g选项,会陷入死循环
    curM = mcode.exec(rst);
    if(curM !== null){
        var lang = curM[1] === undefined ? 'text' : curM[1], cont = curM[2];
        rst = rst.replace(curM[0], '<pre><code class="'+lang+'">'+cont+'</code></pre>');
    }
}
// 中间有空行的
var bcode = new RegExp(/<p><code><\/code>`([a-zA-Z]+)?([^]*)<code><\/code>`<\/p>/,'gu'), curB = 1;
while(curB !== null){
    curB = bcode.exec(rst);
    if(curB !== null){
        var lang = curB[1] === undefined ? 'text' : curB[1], cont = curB[2], cont = cont.replace(/<\/?p>/g, '').replace(/^(\r?\n|\r)/, '');
        rst = rst.replace(curB[0], '<pre><code class="'+lang+'">'+cont+'</code></pre>');
    }
}
///////////////
// 解析 table
///////////////
var tcode = new RegExp(/(\|(?:[^\r\n\|]+\|)+)(?:\r?\n|\r)\|(?:[-—]+\|)+((?:(?:\r?\n|\r)(?:\|(?:[^\n\r\|]+\|)+))+)/,'gu'), curT = 1;
while(curT !== null){
    curT=tcode.exec(rst);
    if(curT !== null){
        console.log(curT[2].split(/\r?\n|\r/));
        var rows = curT[2].split(/\r?\n|\r/).filter(function(a){return a.length === 0 ? false : true;}), rowtrs = '<table><thead><tr><td>'+curT[1].split('|').slice(1,-1).join('</td><td>')+'</td></tr></thead><tbody>';
        console.log(rows);
        for(var i in rows){
            rowtrs += '<tr><td>'+rows[i].split('|').slice(1,-1).join("</td><td>")+'</td></tr>';
        }
        rowtrs += '</tbody></table>';
        rst = rst.replace(curT[0], rowtrs);
    }
};
$('#output').html(rst);