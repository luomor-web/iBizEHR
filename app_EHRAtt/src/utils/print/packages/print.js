import Print from './printarea.js';
/**
 * @file 打印
 * 不传参数打印全局
 * 传入参数'#id', 参数为需要打印局部的盒子标识.
 */
let closeBtn = true;
let localPrint = (obj) => {
  if (closeBtn) {
    closeBtn = false;
    new Print({
      ids: obj.id, // * 局部打印必传入id
      standard: '', // 文档类型，默认是html5，可选 html5，loose，strict
      //extraHead: binding.value.extraHead, // 附加在head标签上的额外标签,使用逗号分隔
      //extraCss: binding.value.extraCss, // 额外的css连接，多个逗号分开
      popTitle: obj.popTitle, // title的标题
      endCallback() { // 调用打印之后的回调事件
        closeBtn = true;
      }
    });
  }
};
let print = (obj)=>{
  if(obj && obj.id){
    //局部打印
    localPrint(obj);
  }else{
    //全局打印
    window.print();
  }
}
export default print;