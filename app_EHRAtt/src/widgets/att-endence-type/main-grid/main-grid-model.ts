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
          name: 'typecode',
          prop: 'typecode',
          dataType: 'TEXT',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'attendencetypeid',
          prop: 'attendencetypeid',
          dataType: 'GUID',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'attendencetypename',
          prop: 'attendencetypename',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'attendencetypename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attendencetypeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'attendencetypeid',
          dataType: 'GUID',
        },
        {
          name: 'attendencetype',
          prop: 'attendencetypeid',
        },
      {
        name: 'n_typecode_like',
        prop: 'n_typecode_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_attendencetypename_like',
        prop: 'n_attendencetypename_like',
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