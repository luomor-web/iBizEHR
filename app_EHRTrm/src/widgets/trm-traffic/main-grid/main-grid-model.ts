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
          name: 'xlmc',
          prop: 'xlmc',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainaddressid',
          prop: 'trmtrainaddressid',
          dataType: 'PICKUP',
        },
        {
          name: 'jtfs',
          prop: 'jtfs',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrafficname',
          prop: 'trmtrafficname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrafficname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrafficid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrafficid',
          dataType: 'GUID',
        },
        {
          name: 'trmtraffic',
          prop: 'trmtrafficid',
        },
      {
        name: 'n_trmtrafficname_like',
        prop: 'n_trmtrafficname_like',
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