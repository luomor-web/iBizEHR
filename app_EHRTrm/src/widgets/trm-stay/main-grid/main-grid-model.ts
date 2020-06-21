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
          name: 'fjlx',
          prop: 'fjlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainaddressid',
          prop: 'trmtrainaddressid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'trmstayname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmstayid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmstayid',
          dataType: 'GUID',
        },
        {
          name: 'fjsl',
          prop: 'fjsl',
          dataType: 'INT',
        },
        {
          name: 'trmstay',
          prop: 'trmstayid',
        },
      {
        name: 'n_trmstayname_like',
        prop: 'n_trmstayname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_fjlx_eq',
        prop: 'n_fjlx_eq',
        dataType: 'SSCODELIST',
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