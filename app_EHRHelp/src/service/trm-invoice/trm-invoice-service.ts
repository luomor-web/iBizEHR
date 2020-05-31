import { Http,Util } from '@/utils';
import TrmInvoiceServiceBase from './trm-invoice-service-base';


/**
 * 开票信息服务对象
 *
 * @export
 * @class TrmInvoiceService
 * @extends {TrmInvoiceServiceBase}
 */
export default class TrmInvoiceService extends TrmInvoiceServiceBase {

    /**
     * Creates an instance of  TrmInvoiceService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmInvoiceService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}