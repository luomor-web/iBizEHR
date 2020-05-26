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
          name: 'xh',
          prop: 'xh',
          dataType: 'TEXT',
        },
        {
          name: 'xkml',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmxkmlname',
          prop: 'pcmxkmlname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmxkmlname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmxkmlid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmxkmlid',
          dataType: 'GUID',
        },
        {
          name: 'xkml_text',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmxkml',
          prop: 'pcmxkmlid',
        },
      {
        name: 'n_xkml_eq',
        prop: 'n_xkml_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pcmxkmlname_like',
        prop: 'n_pcmxkmlname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_nd_eq',
        prop: 'n_nd_eq',
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