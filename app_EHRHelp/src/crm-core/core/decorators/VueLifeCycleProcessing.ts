/**
 * Vue多层继承生命周期处理
 *
 * @export
 * @param {*} constructor
 * @returns {*}
 */
export function VueLifeCycleProcessing(constructor: any): any {
    // 原型
    const p = constructor.prototype;
    // 方法名数组
    const methodNames: string[] = ['beforeCreate', 'created', 'beforeMount', 'mounted', 'beforeUpdate', 'updated', 'activated', 'deactivated', 'beforeDestroy', 'destroyed', 'errorCaptured'];
    methodNames.forEach((name: string) => {
        if (!p.hasOwnProperty(name) && p[name]) {
            p[name] = function () {
                if (this[name]) {
                    this[name]();
                }
            }
        }
    });
    if (!p.hasOwnProperty('render') && p.render) {
        p.render = function (h: any) {
            if (this.render) {
                return this.render(h);
            }
        }
    }
}