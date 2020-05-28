import { Http,Util } from '@/utils';
import NationMGRServiceBase from './nation-mgr-service-base';


/**
 * 民族管理服务对象
 *
 * @export
 * @class NationMGRService
 * @extends {NationMGRServiceBase}
 */
export default class NationMGRService extends NationMGRServiceBase {

    /**
     * Creates an instance of  NationMGRService.
     * 
     * @param {*} [opts={}]
     * @memberof  NationMGRService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}