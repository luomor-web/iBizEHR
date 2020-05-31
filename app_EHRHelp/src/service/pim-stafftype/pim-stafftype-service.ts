import { Http,Util } from '@/utils';
import PimStafftypeServiceBase from './pim-stafftype-service-base';


/**
 * 员工类型管理服务对象
 *
 * @export
 * @class PimStafftypeService
 * @extends {PimStafftypeServiceBase}
 */
export default class PimStafftypeService extends PimStafftypeServiceBase {

    /**
     * Creates an instance of  PimStafftypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimStafftypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}