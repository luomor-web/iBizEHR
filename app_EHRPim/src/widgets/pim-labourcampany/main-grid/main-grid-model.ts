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
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'legalperosn',
          prop: 'legalperosn',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'lxdz',
          prop: 'lxdz',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimlabourcampanyname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimlabourcampanyid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimlabourcampanyid',
          dataType: 'GUID',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'lxr',
          prop: 'lxr',
          dataType: 'TEXT',
        },
        {
          name: 'regcapital',
          prop: 'regcapital',
          dataType: 'TEXT',
        },
        {
          name: 'pimlabourcampanyname',
          prop: 'pimlabourcampanyname',
          dataType: 'TEXT',
        },
        {
          name: 'lxfs',
          prop: 'lxfs',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'pimlabourcampany',
          prop: 'pimlabourcampanyid',
        },
      {
        name: 'n_pimlabourcampanyname_like',
        prop: 'n_pimlabourcampanyname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_lxr_like',
        prop: 'n_lxr_like',
        dataType: 'TEXT',
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