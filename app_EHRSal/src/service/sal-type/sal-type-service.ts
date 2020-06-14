import { Http,Util } from '@/utils';
import SalTypeServiceBase from './sal-type-service-base';


/**
 * 薪酬类型服务对象
 *
 * @export
 * @class SalTypeService
 * @extends {SalTypeServiceBase}
 */
export default class SalTypeService extends SalTypeServiceBase {

    /**
     * Creates an instance of  SalTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}