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
          name: 'shgz',
          prop: 'shgz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimstafftypename',
          prop: 'pimstafftypename',
          dataType: 'TEXT',
        },
        {
          name: 'sbm',
          prop: 'sbm',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimstafftypename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimstafftypeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimstafftypeid',
          dataType: 'GUID',
        },
        {
          name: 'pimstafftype',
          prop: 'pimstafftypeid',
        },
      {
        name: 'n_pimstafftypeid_eq',
        prop: 'n_pimstafftypeid_eq',
        dataType: 'GUID',
      },
      {
        name: 'n_pimstafftypename_like',
        prop: 'n_pimstafftypename_like',
        dataType: 'TEXT',
      },
      {
        name: 'pimstafftype',
        prop: 'pimstafftypeid',
        dataType: 'FONTKEY',
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