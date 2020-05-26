import { Http,Util } from '@/utils';
import ORMORGInfoServiceBase from './ormorginfo-service-base';


/**
 * 组织信息服务对象
 *
 * @export
 * @class ORMORGInfoService
 * @extends {ORMORGInfoServiceBase}
 */
export default class ORMORGInfoService extends ORMORGInfoServiceBase {

    /**
     * Creates an instance of  ORMORGInfoService.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMORGInfoService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}