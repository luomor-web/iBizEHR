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
          name: 'soctypeid',
          prop: 'soctypeid',
          dataType: 'PICKUP',
        },
        {
          name: 'personrate',
          prop: 'personrate',
          dataType: 'FLOAT',
        },
        {
          name: 'highnum',
          prop: 'highnum',
          dataType: 'FLOAT',
        },
        {
          name: 'memo',
          prop: 'memo',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'companyrate',
          prop: 'companyrate',
          dataType: 'FLOAT',
        },
        {
          name: 'personnum',
          prop: 'personnum',
          dataType: 'FLOAT',
        },
        {
          name: 'srfmajortext',
          prop: 'socruledetailname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'socruledetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'socruledetailid',
          dataType: 'GUID',
        },
        {
          name: 'companyamount',
          prop: 'companyamount',
          dataType: 'FLOAT',
        },
        {
          name: 'personamount',
          prop: 'personamount',
          dataType: 'FLOAT',
        },
        {
          name: 'socruleid',
          prop: 'socruleid',
          dataType: 'PICKUP',
        },
        {
          name: 'ordervalue',
          prop: 'ordervalue',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'soctypename',
          prop: 'soctypename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'companynum',
          prop: 'companynum',
          dataType: 'FLOAT',
        },
        {
          name: 'lownum',
          prop: 'lownum',
          dataType: 'FLOAT',
        },
        {
          name: 'socruledetail',
          prop: 'socruledetailid',
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