import { Http,Util } from '@/utils';
import NationMgrServiceBase from './nation-mgr-service-base';


/**
 * 民族管理服务对象
 *
 * @export
 * @class NationMgrService
 * @extends {NationMgrServiceBase}
 */
export default class NationMgrService extends NationMgrServiceBase {

    /**
     * Creates an instance of  NationMgrService.
     * 
     * @param {*} [opts={}]
     * @memberof  NationMgrService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}