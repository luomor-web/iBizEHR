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
          name: 'jb',
          prop: 'jb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainagencyid',
          prop: 'trmtrainagencyid',
          dataType: 'PICKUP',
        },
        {
          name: 'nr',
          prop: 'nr',
          dataType: 'TEXT',
        },
        {
          name: 'dm',
          prop: 'dm',
          dataType: 'TEXT',
        },
        {
          name: 'trmcoursesystemname',
          prop: 'trmcoursesystemname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmcoursesystemname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmcoursesystemid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmcoursesystemid',
          dataType: 'GUID',
        },
        {
          name: 'dygx',
          prop: 'dygx',
          dataType: 'TEXT',
        },
        {
          name: 'trmcoursesystem',
          prop: 'trmcoursesystemid',
        },
      {
        name: 'n_trmcoursesystemname_like',
        prop: 'n_trmcoursesystemname_like',
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