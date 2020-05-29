/**
 * 界面行为工具类
 */
export class UIActionTool {

    /**
     * 处理应用上下文参数
     * 
     * @param actionTarget 数据目标
     * @param args  传入数据对象
     * @param param 传入应用上下数据参数
     */
    public static handleContextParam(actionTarget: any, args: any, context: any) {
        return this.formatData(actionTarget, args, context);
    }

    /**
     * 处理界面行为参数
     * 
     * @param actionTarget 数据目标
     * @param args  传入数据对象
     * @param param 传入界面行为附加参数
     */
    public static handleActionParam(actionTarget: any, args: any, params: any) {
        return this.formatData(actionTarget, args, params);
    }

    /**
     * 格式化数据
     *
     * @private
     * @static
     * @param {*} actionTarget
     * @param {*} args
     * @param {*} _params
     * @returns {*}
     * @memberof UIActionTool
     */
    private static formatData(actionTarget: any, args: any, _params: any): any {
        let _data: any = {};
        if (Object.is(actionTarget, 'SINGLEKEY')) {
            let [arg] = args;
            Object.keys(_params).forEach((name: string) => {
                let hasProperty = true;
                if (!name) {
                    return;
                }
                let value: string | null = _params[name];
                if (value && value.startsWith('%') && value.endsWith('%')) {
                    const key = value.substring(1, value.length - 1);
                    if (arg && arg.hasOwnProperty(key)) {
                        value = (arg[key] !== null && arg[key] !== undefined) ? arg[key] : null;
                    } else {
                        hasProperty = false;
                    }
                }
                if(hasProperty){
                    Object.assign(_data, { [name]: value });
                }
            });
        } else if (Object.is(actionTarget, 'MULTIKEY')) {
            Object.keys(_params).forEach((name: string) => {
                let noPropertyNum = 0;
                if (!name) {
                    return;
                }
                let value: string | null = _params[name];
                let values: any[] = [];
                if (value && value.startsWith('%') && value.endsWith('%')) {
                    const key = value.substring(1, value.length - 1);
                    args.forEach((arg: any) => {
                        if (arg && arg.hasOwnProperty(key)) {
                            value = (arg[key] !== null && arg[key] !== undefined) ? arg[key] : null;
                        } else {
                            value = null;
                            noPropertyNum++;
                        }
                        values.push(value);
                    });
                }
                if(values.length !== noPropertyNum){
                    Object.assign(_data, { [name]: values.length > 0 ? values.join(';') : value });
                }
            });
        }
        return _data;
    }

}