import { Http } from './../../utils/http/http';
import UtilService from '@/utilservice/util-service';

export default class AppDashboardDesignService {

    /**
     * 工具服务对象
     *
     * @protected
     * @type {UtilService}
     * @memberof AppDashboardDesignService
     */
    protected utilService: UtilService = new UtilService();

    /**
     * 加载数据模型
     *
     * @param {string} serviceName
     * @param {*} context
     * @param {*} viewparams
     * @memberof AppDashboardDesignService
     */
    public loadModel(serviceName: string, context: any, viewparams: any) {
        return new Promise((resolve: any, reject: any) => {
            this.utilService.getService(serviceName).then((service: any) => {
                service.loadModelData(JSON.stringify(context), viewparams).then((response: any) => {
                    resolve(response);
                }).catch((response: any) => {
                    reject(response);
                });
            }).catch((response: any) => {
                reject(response);
            });
        });
    }

    /**
     * 保存模型
     *
     * @param {string} serviceName
     * @param {*} context
     * @param {*} viewparams
     * @returns
     * @memberof AppDashboardDesignService
     */
    public saveModel(serviceName: string, context: any, viewparams: any) {
        return new Promise((resolve: any, reject: any) => {
            this.utilService.getService(serviceName).then((service: any) => {
                service.saveModelData(JSON.stringify(context), '', viewparams).then((response: any) => {
                    resolve(response);
                }).catch((response: any) => {
                    reject(response);
                });
            }).catch((response: any) => {
                reject(response);
            });
        });
    }

    /**
     * 加载门户部件集合
     *
     * @memberof AppDashboardDesignService
     */
    public loadPortletList(context: any, viewparams: any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            Http.getInstance().get('./assets/json/portlet-data.json').then((response: any) => {
                if (response && response.status === 200 && response.data && Array.isArray(response.data)) {
                    const datas: any[] = this.filterData(response.data, viewparams.appdeName);
                    const list = this.prepareList(datas);
                    const groups = this.prepareGroup(datas);
                    resolve({data: datas, result: list.reverse(), groups: groups});
                }
            }).catch((response: any) => {
                console.log(response.status);
            });
        });
    }

    /**
     * 过滤数据
     *
     * @param {any[]} datas
     * @memberof AppDashboardDesignService
     */
    public filterData(datas: any[] = [], dataType: string): any[] {
        let items: any[] = [];
        datas.forEach((data: any) => {
            if(Object.is(data.type, 'app')) {
                items.push(data);
            }
            if(Object.is(data.appCodeName, dataType)) {
                items.push(data);
            }
        });
        return items;
    }

    /**
     * 分组集合
     *
     * @param {any[]} [datas=[]]
     * @returns {any[]}
     * @memberof AppDashboardDesignService
     */
    public prepareGroup(datas: any[] = []): any[] {
        let items: any[] = [];
        datas.forEach((data: any) => {
            let item = items.find((item: any) => Object.is(item.value, data.groupCodeName));
            if(item) {
                let _item = item.children.find((a: any) => Object.is(a.portletCodeName, data.portletCodeName));
                if(!_item) {
                    item.children.push(data);
                }
            } else {
                items.push({name: data.groupName, value: data.groupCodeName, children: [data]});
            }
        });
        return items;
    }

    /**
     * 准备list集合
     *
     * @memberof AppDashboardDesignService
     */
    public prepareList(datas: any[] = []): any[] {
        let list: any[] = [];
		datas.forEach((data: any) => {
			let item = list.find((item: any) => Object.is(data.type, item.type));
			if(!item) {
				item = {};
				Object.assign(item, { 
					type: data.type,
					name: Object.is(data.type, 'app') ? "全局" : data.appName,
					children: []
				});
				list.push(item);
			}
			this.prepareList2(item.children, data);
        })
        return list
	}

    /**
     * 准备list项集合
     *
     * @param {any[]} [children=[]]
     * @param {*} [data={}]
     * @memberof AppDashboardDesignService
     */
    public prepareList2(children: any[] = [], data: any = {}) {
		let item = children.find((item: any) => Object.is(data.groupCodeName, item.type));
		if(!item) {
			item = {};
			Object.assign(item, { 
				type: data.groupCodeName,
				name: data.groupName,
				children: []
			});
			children.push(item);
		}
		let _item = item.children.find((a: any) => Object.is(a.portletCodeName, data.portletCodeName));
        if(!_item) {
            item.children.push(data);
        }
    }
}