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
          name: 'trmtraincourseid',
          prop: 'trmtraincourseid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainteachername',
          prop: 'trmtrainteachername',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainplantermname',
          prop: 'trmtrainplantermname',
          dataType: 'TEXT',
        },
        {
          name: 'bjzt',
          prop: 'bjzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmtrainteacherid',
          prop: 'trmtrainteacherid',
          dataType: 'PICKUP',
        },
        {
          name: 'bzr',
          prop: 'bzr',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainagencyname',
          prop: 'trmtrainagencyname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainplanid',
          prop: 'trmtrainplanid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmdemdeftionname',
          prop: 'trmdemdeftionname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainplanname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtraincoursename',
          prop: 'trmtraincoursename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainplantermid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainplantermid',
          dataType: 'GUID',
        },
        {
          name: 'jhkssj',
          prop: 'jhkssj',
          dataType: 'DATE',
        },
        {
          name: 'trmtrainagencyid',
          prop: 'trmtrainagencyid',
          dataType: 'PICKUP',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'jhjssj',
          prop: 'jhjssj',
          dataType: 'DATE',
        },
        {
          name: 'trmtrainplanterm',
          prop: 'trmtrainplantermid',
        },
      {
        name: 'n_trmtrainagencyname_eq',
        prop: 'n_trmtrainagencyname_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtraincoursename_eq',
        prop: 'n_trmtraincoursename_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtrainteachername_eq',
        prop: 'n_trmtrainteachername_eq',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_zt_eq',
        prop: 'n_zt_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_trmtrainagencyid_eq',
        prop: 'n_trmtrainagencyid_eq',
      },
      {
        name: 'n_trmtraincourseid_eq',
        prop: 'n_trmtraincourseid_eq',
      },
      {
        name: 'n_trmtrainteacherid_eq',
        prop: 'n_trmtrainteacherid_eq',
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