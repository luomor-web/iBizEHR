/**
 * 界面行为工具类
 */
export class UIActionTool {

    /**
     * 处理应用上下文参数
     * 
     * @param actionTarget 数据目标
     * @param args  传入数据对象
     * @param parentContext 父上下文
     * @param parentParams  父参数
     * @param param 传入应用上下数据参数
     */
    public static handleContextParam(actionTarget: any, args: any,parentContext:any,parentParams:any, context: any) {
        return this.formatData(actionTarget, args,parentContext,parentParams,context);
    }

    /**
     * 处理界面行为参数
     * 
     * @param actionTarget 数据目标
     * @param args  传入数据对象
     * @param parentContext 父上下文
     * @param parentParams  父参数
     * @param param 传入界面行为附加参数
     */
    public static handleActionParam(actionTarget: any, args: any,parentContext:any,parentParams:any, params: any) {
        return this.formatData(actionTarget, args,parentContext,parentParams,params);
    }

    /**
     * 格式化数据
     *
     * @private
     * @static
     * @param {*} actionTarget
     * @param {*} args
     * @param parentContext
     * @param parentParams
     * @param {*} _params
     * @returns {*}
     * @memberof UIActionTool
     */
    private static formatData(actionTarget: any, args: any,parentContext:any,parentParams:any, _params: any): any {
        let _data: any = {};
        if (Object.is(actionTarget, 'SINGLEKEY') || Object.is(actionTarget, 'NONE')) {
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
                    } else if(parentContext && parentContext.hasOwnProperty(key)){
                        value = (parentContext[key] !== null && parentContext[key] !== undefined) ? parentContext[key] : null;
                    }else if(parentParams && parentParams.hasOwnProperty(key)){
                        value = (parentParams[key] !== null && parentParams[key] !== undefined) ? parentParams[key] : null;
                    }else {
                        hasProperty = false;
                    }
                }
                if(hasProperty){
                    Object.assign(_data, { [name.toLowerCase()]: value });
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
                        }else if(parentContext && parentContext.hasOwnProperty(key)){
                            value = (parentContext[key] !== null && parentContext[key] !== undefined) ? parentContext[key] : null;
                        }else if(parentParams && parentParams.hasOwnProperty(key)){
                            value = (parentParams[key] !== null && parentParams[key] !== undefined) ? parentParams[key] : null;
                        }else {
                            value = null;
                            noPropertyNum++;
                        }
                        values.push(value);
                    });
                }
                if(values.length !== noPropertyNum){
                    Object.assign(_data, { [name.toLowerCase()]: values.length > 0 ? values.join(',') : value });
                }
            });
        }
        return _data;
    }

}