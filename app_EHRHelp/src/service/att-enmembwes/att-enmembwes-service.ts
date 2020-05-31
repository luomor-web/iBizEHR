import { Http,Util } from '@/utils';
import AttEnmembwesServiceBase from './att-enmembwes-service-base';


/**
 * 考勤员(停用)服务对象
 *
 * @export
 * @class AttEnmembwesService
 * @extends {AttEnmembwesServiceBase}
 */
export default class AttEnmembwesService extends AttEnmembwesServiceBase {

    /**
     * Creates an instance of  AttEnmembwesService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEnmembwesService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}