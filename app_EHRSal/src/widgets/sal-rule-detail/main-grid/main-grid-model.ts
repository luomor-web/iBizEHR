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
          name: 'checkrule',
          prop: 'checkrule',
          dataType: 'SSCODELIST',
        },
        {
          name: 'salparamname',
          prop: 'salparamname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'salparamid2',
          prop: 'salparamid2',
          dataType: 'PICKUP',
        },
        {
          name: 'salparamid',
          prop: 'salparamid',
          dataType: 'PICKUP',
        },
        {
          name: 'salparamname2',
          prop: 'salparamname2',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'salruleid',
          prop: 'salruleid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'salruledetailname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'salruledetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'salruledetailid',
          dataType: 'GUID',
        },
        {
          name: 'salruledetail',
          prop: 'salruledetailid',
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