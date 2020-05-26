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
          name: 'project_size',
          prop: 'project_size',
          dataType: 'TEXT',
        },
        {
          name: 'target_finish_date',
          prop: 'target_finish_date',
          dataType: 'TEXT',
        },
        {
          name: 'project_name',
          prop: 'project_name',
          dataType: 'TEXT',
        },
        {
          name: 'target_start_date',
          prop: 'target_start_date',
          dataType: 'TEXT',
        },
        {
          name: 'isdirectlymanage',
          prop: 'isdirectlymanage',
          dataType: 'SSCODELIST',
        },
        {
          name: 'engineeringscale',
          prop: 'engineeringscale',
          dataType: 'SSCODELIST',
        },
        {
          name: 'project_status_name',
          prop: 'project_status_name',
          dataType: 'TEXT',
        },
        {
          name: 'project_number',
          prop: 'project_number',
          dataType: 'TEXT',
        },
        {
          name: 'project_type',
          prop: 'project_type',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'project_name',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormxmglid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'ormxmglid',
          dataType: 'GUID',
        },
        {
          name: 'org_id',
          prop: 'org_id',
          dataType: 'TEXT',
        },
        {
          name: 'procapitalatt',
          prop: 'procapitalatt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'project_full_name',
          prop: 'project_full_name',
          dataType: 'TEXT',
        },
        {
          name: 'engineeringbustype',
          prop: 'engineeringbustype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'engineeringpurpose',
          prop: 'engineeringpurpose',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormxmglid',
          prop: 'ormxmglid',
          dataType: 'GUID',
        },
        {
          name: 'project_status_code',
          prop: 'project_status_code',
          dataType: 'TEXT',
        },
        {
          name: 'ormxmgl',
          prop: 'ormxmglid',
        },
      {
        name: 'n_project_number_like',
        prop: 'n_project_number_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_project_name_like',
        prop: 'n_project_name_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_project_type_eq',
        prop: 'n_project_type_eq',
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