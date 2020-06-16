import { Http,Util } from '@/utils';
import SocTypeServiceBase from './soc-type-service-base';


/**
 * 保险类型服务对象
 *
 * @export
 * @class SocTypeService
 * @extends {SocTypeServiceBase}
 */
export default class SocTypeService extends SocTypeServiceBase {

    /**
     * Creates an instance of  SocTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  SocTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}