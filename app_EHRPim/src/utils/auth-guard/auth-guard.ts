import { Http } from '../http/http';

/**
 * AuthGuard net 对象
 * 调用 getInstance() 获取实例
 *
 * @class Http
 */
export class AuthGuard {

    /**
     * 获取 Auth 单例对象
     *
     * @static
     * @returns {Auth}
     * @memberof Auth
     */
    public static getInstance(): AuthGuard {
        if (!AuthGuard.auth) {
            AuthGuard.auth = new AuthGuard();
        }
        return this.auth;
    }

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {AuthGuard}
     * @memberof AuthGuard
     */
    private static auth: AuthGuard;

    /**
     * Creates an instance of AuthGuard.
     * 私有构造，拒绝通过 new 创建对象
     * 
     * @memberof AuthGuard
     */
    private constructor() { }

    /**
     * post请求
     *
     * @param {string} url url 请求路径
     * @param {*} [params={}] 请求参数
     * @returns {Promise<any>} 请求相响应对象
     * @memberof AuthGuard
     */
    public authGuard(url: string, params: any = {}, router: any): Promise<boolean> {
        return new Promise((resolve: any, reject: any) => {
            const get: Promise<any> = Http.getInstance().get(url);
            get.then((response: any) => {
                if (response && response.status === 200) {
                    let { data }: { data: any } = response;
                    if (data) {
                        // token认证把用户信息放入应用级数据
                        if(localStorage.getItem('user')){
                            let user:any = JSON.parse(localStorage.getItem('user') as string);
                            let localAppData:any = {};
                            if(user.sessionParams){
                                localAppData = {context:user.sessionParams};
                                Object.assign(localAppData,data);
                            }
                            data = JSON.parse(JSON.stringify(localAppData));
                        }
                        router.app.$store.commit('addAppData', data);
                        // 提交统一资源数据
                        router.app.$store.dispatch('unifiedresource/commitResourceData', data);
                    }
                }
                resolve(true);
            }).catch((error: any) => {
                resolve(true);
                console.error("获取应用数据出现异常");
            });
        });
    }

}
