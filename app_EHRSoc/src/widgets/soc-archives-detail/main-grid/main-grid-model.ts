/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'personrate',
          prop: 'personrate',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'highnum',
          prop: 'highnum',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'socruledetailid',
          prop: 'socruledetailid',
          dataType: 'PICKUP',
        },
        {
          name: 'companyrate',
          prop: 'companyrate',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'personnum',
          prop: 'personnum',
          dataType: 'FLOAT',
        },
        {
          name: 'srfmajortext',
          prop: 'socarchivesdetailname',
          dataType: 'TEXT',
        },
        {
          name: 'companyamount',
          prop: 'companyamount',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfkey',
          prop: 'socarchivesdetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'socarchivesdetailid',
          dataType: 'GUID',
        },
        {
          name: 'personamount',
          prop: 'personamount',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ordervalue',
          prop: 'ordervalue',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'soctypename',
          prop: 'soctypename',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'companynum',
          prop: 'companynum',
          dataType: 'FLOAT',
        },
        {
          name: 'socarchivesid',
          prop: 'socarchivesid',
          dataType: 'PICKUP',
        },
        {
          name: 'lownum',
          prop: 'lownum',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'socarchivesdetail',
          prop: 'socarchivesdetailid',
        },
        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}