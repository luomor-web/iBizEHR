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
          name: 'attendancemreportmxid',
          prop: 'attendancemreportid',
          dataType: 'PICKUP',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormbmkqdzid',
          prop: 'ormbmkqdzid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainplantermid',
          prop: 'trmtrainplantermid',
          dataType: 'PICKUP',
        },
        {
          name: 'dksjqd',
          prop: 'dksjqd',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'attendancerecordname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'attendancerecordid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attendancerecordid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zjhm',
          prop: 'zjhm',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'attenddate',
          prop: 'attenddate',
          dataType: 'DATE',
        },
        {
          name: 'dksjqt',
          prop: 'dksjqt',
          dataType: 'DATETIME',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'attendancerecord',
          prop: 'attendancerecordid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_dkfs_eq',
        prop: 'n_dkfs_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'n_ormorgsectorname_like',
        dataType: 'PICKUPDATA',
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