import { Http,Util } from '@/utils';
import VacOveralltionServiceBase from './vac-overalltion-service-base';


/**
 * 统筹休假(暂时停用)服务对象
 *
 * @export
 * @class VacOveralltionService
 * @extends {VacOveralltionServiceBase}
 */
export default class VacOveralltionService extends VacOveralltionServiceBase {

    /**
     * Creates an instance of  VacOveralltionService.
     * 
     * @param {*} [opts={}]
     * @memberof  VacOveralltionService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}