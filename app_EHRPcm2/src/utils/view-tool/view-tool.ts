import qs from 'qs';
import { Route } from 'vue-router';

export class ViewTool {
    /**
     * 解析参数，返回viewdata
     *
     * @static
     * @param {any[]} [args] 多项数据
     * @param {*} [viewParam] 视图参数
     * @param {any[]} [deResParameters] 关系实体参数对象
     * @param {any[]} [parameters] 当前应用视图参数对象
     * @param {*} [data] 行为参数
     * @returns
     * @memberof ViewTool
     */
    public static getViewdata(viewParam: any = {}, deResParameters: any[], parameters: any[], args: any[], data: any = {}): any {
        let viewdata: any = {};

        let [arg] = args;
        arg = arg ? arg : {};

        // 首页视图参数
        const indexViewParam: any = ViewTool.getIndexViewParam();
        Object.assign(viewdata, indexViewParam);

        // 关系应用实体参数
        deResParameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
            if (viewParam[parameterName] && !Object.is(viewParam[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: viewParam[parameterName] });
            } else if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: arg[parameterName] });
            }
        });

        // 当前视图参数（应用实体视图）
        parameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
            if (arg[parameterName] && !Object.is(arg[parameterName], '')) {
                Object.assign(viewdata, { [parameterName]: arg[parameterName] });
            }
        });

        // 视图常规参数
        Object.assign(viewdata, data);
        // 传入父视图的srfsessionid
        Object.assign(viewdata, {srfsessionid:viewParam['srfsessionid']});
        return viewdata;
    }

    /**
     * 处理路由路径
     *
     * @static
     * @param {Route} route 路由
     * @param {*} [viewParam={}]
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @returns {string}
     * @memberof ViewTool
     */
    public static buildUpRoutePath(route: Route, viewParam: any = {}, deResParameters: any[], parameters: any[], args: any[], data: any): string {
        const indexRoutePath = this.getIndexRoutePath(route);
        const deResRoutePath = this.getDeResRoutePath(viewParam, deResParameters, args);
        const deRoutePath = this.getActiveRoutePath(parameters, args, data);
        return `${indexRoutePath}${deResRoutePath}${deRoutePath}`;
    }

    /**
     * 获取首页根路由路径
     *
     * @static
     * @param {Route} route 路由对象
     * @returns {string}
     * @memberof ViewTool
     */
    public static getIndexRoutePath(route: Route): string {
        const { parameters: _parameters }: { parameters: any[] } = route.meta;
        const { pathName: _pathName, parameterName: _parameterName }: { pathName: string, parameterName: string } = _parameters[0];
        const param = route.params[_parameterName];
        if (param && !Object.is(param, '')) {
            return `/${_pathName}/${param}`;
        }
        return `/${_pathName}/null`;
    }

    /**
     * 获取关系实体路径
     *
     * @static
     * @param {*} [viewParam={}] 视图参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} args 多项数据
     * @returns {string}
     * @memberof ViewTool
     */
    public static getDeResRoutePath(viewParam: any = {}, deResParameters: any[], args: any[]): string {
        let routePath: string = '';
        let [arg] = args;
        arg = arg ? arg : {};
        deResParameters.forEach(({ pathName, parameterName }: { pathName: string, parameterName: string }) => {
            let value:any = null;
            if (viewParam[parameterName] && !Object.is(viewParam[parameterName], '') && !Object.is(viewParam[parameterName], 'null')) {
                value = viewParam[parameterName];
            } else if (arg[parameterName] && !Object.is(arg[parameterName], '') && !Object.is(arg[parameterName], 'null')) {
                value = arg[parameterName];
            }
            routePath = `${routePath}/${pathName}/${value}`;
        });
        return routePath;
    }

    /**
     * 当前激活路由路径
     *
     * @static
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @returns {string}
     * @memberof ViewTool
     */
    public static getActiveRoutePath(parameters: any[], args: any[], data: any): string {
        let routePath: string = '';
        // 不存在应用实体
        if (parameters.length === 1) {
            const [{ pathName, parameterName }] = parameters;
            routePath = `/${pathName}`;
            if (Object.keys(data).length > 0) {
                routePath = `${routePath}?${qs.stringify(data, { delimiter: ';' })}`;
            }
        } else if (parameters.length === 2) {
            let [arg] = args;
            arg = arg ? arg : {};
            const [{ pathName: _pathName, parameterName: _parameterName }, { pathName: _pathName2, parameterName: _parameterName2 }] = parameters;
            const _value: any = arg[_parameterName] && !Object.is(arg[_parameterName], '') ?
                arg[_parameterName] : null;
            routePath = `/${_pathName}/${_value}/${_pathName2}`;
            if (Object.keys(data).length > 0) {
                routePath = `${routePath}?${qs.stringify(data, { delimiter: ';' })}`;
            }
        }
        return routePath;
    }

    /**
     * 格式化路由参数
     *
     * @static
     * @param {*} params
     * @returns {*}
     * @memberof ViewTool
     */
    public static formatRouteParams(params: any,route:any,context:any,viewparams:any): void {
        Object.keys(params).forEach((key: string,index:number) => {
            const param: string | null | undefined = params[key];
            if (!param || Object.is(param, '') || Object.is(param, 'null')) {
                return;
            }
            if (param.indexOf('=') > 0) {
                const _param = qs.parse(param, { delimiter: ';' });
                Object.assign(context, _param);
            } else {
                Object.assign(context, { [key]: param });
            }
        });
        if(route && route.fullPath && route.fullPath.indexOf("?") > -1){
            const _viewparams:any = route.fullPath.slice(route.fullPath.indexOf("?")+1);
            const _viewparamArray:Array<string> = decodeURIComponent(_viewparams).split(";")
            if(_viewparamArray.length > 0){
                _viewparamArray.forEach((item:any) =>{
                    Object.assign(viewparams, qs.parse(item));
                })
            }
        }
    }

    /**
     * 首页路由结构参数
     *
     * @private
     * @static
     * @type {any[]}
     * @memberof ViewTool
     */
    private static indexParameters: any[] = [];

    /**
     * 设置首页路由结构参数
     *
     * @static
     * @param {any[]} parameters
     * @memberof ViewTool
     */
    public static setIndexParameters(parameters: any[]): void {
        this.indexParameters = [...parameters]
    }

    /**
     * 获取首页路由结构参数
     *
     * @static
     * @returns {any[]}
     * @memberof ViewTool
     */
    public static getIndexParameters(): any[] {
        return this.indexParameters;
    }

    /**
     * 首页视图参数
     *
     * @static
     * @type {*}
     * @memberof ViewTool
     */
    public static indexViewParam: any = {};

    /**
     * 设置首页视图参数
     *
     * @static
     * @param {*} [viewParam={}]
     * @memberof ViewTool
     */
    public static setIndexViewParam(viewParam: any = {}): void {
        Object.assign(this.indexViewParam, viewParam);
    }

    /**
     * 获取首页视图参数
     *
     * @static
     * @returns {*}
     * @memberof ViewTool
     */
    public static getIndexViewParam(): any {
        return this.indexViewParam;
    }
}