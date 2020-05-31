import { Http,Util } from '@/utils';
import OrmTitleServiceBase from './orm-title-service-base';


/**
 * 头衔管理服务对象
 *
 * @export
 * @class OrmTitleService
 * @extends {OrmTitleServiceBase}
 */
export default class OrmTitleService extends OrmTitleServiceBase {

    /**
     * Creates an instance of  OrmTitleService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmTitleService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}