import Print from './packages/print.js';
import vPrint from './packages/vPrint.js'
Print.install = function(Vue) {
    Vue.prototype.$print = function(obj){
      Print(obj)
    }
};
vPrint.install= function(Vue) {
  Vue.directive('print', vPrint);
};
export {Print,vPrint} ;
