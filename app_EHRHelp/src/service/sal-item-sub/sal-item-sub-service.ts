import { Http,Util } from '@/utils';
import SalItemSubServiceBase from './sal-item-sub-service-base';


/**
 * 薪酬要素项维护服务对象
 *
 * @export
 * @class SalItemSubService
 * @extends {SalItemSubServiceBase}
 */
export default class SalItemSubService extends SalItemSubServiceBase {

    /**
     * Creates an instance of  SalItemSubService.
     * 
     * @param {*} [opts={}]
     * @memberof  SalItemSubService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}