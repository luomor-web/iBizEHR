/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmtrainplantermid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainplanname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'trmtrainplanname',
        prop: 'trmtrainplanname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'trmtrainplantermname',
        prop: 'trmtrainplantermname',
        dataType: 'TEXT',
      },
      {
        name: 'jhkssj',
        prop: 'jhkssj',
        dataType: 'DATE',
      },
      {
        name: 'jhjssj',
        prop: 'jhjssj',
        dataType: 'DATE',
      },
      {
        name: 'trmtrainagencyname',
        prop: 'trmtrainagencyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pxdd',
        prop: 'pxdd',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'trmtraincoursename',
        prop: 'trmtraincoursename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'trmtrainteachername',
        prop: 'trmtrainteachername',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'bzr',
        prop: 'bzr',
        dataType: 'TEXT',
      },
      {
        name: 'bjzt',
        prop: 'bjzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'trmtrainplanid',
        prop: 'trmtrainplanid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtraincourseid',
        prop: 'trmtraincourseid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainagencyid',
        prop: 'trmtrainagencyid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainplantermid',
        prop: 'trmtrainplantermid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainplanterm',
        prop: 'trmtrainplantermid',
        dataType: 'FONTKEY',
      },
    ]
  }

}