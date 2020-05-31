/**
 * MaturityDueEditForm 部件模型
 *
 * @export
 * @class MaturityDueEditFormModel
 */
export default class MaturityDueEditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MaturityDueEditFormModel
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
        prop: 'pimdistirbutionid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'fplx',
        prop: 'fplx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fpzt',
        prop: 'fpzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'cfplx',
        prop: 'cfplx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'gzdq',
        prop: 'gzdq',
        dataType: 'TEXT',
      },
      {
        name: 'gzdd',
        prop: 'gzdd',
        dataType: 'TEXT',
      },
      {
        name: 'rzkssj',
        prop: 'rzkssj',
        dataType: 'DATE',
      },
      {
        name: 'rzjssj',
        prop: 'rzjssj',
        dataType: 'DATE',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimdistirbutionid',
        prop: 'pimdistirbutionid',
        dataType: 'GUID',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimdistirbution',
        prop: 'pimdistirbutionid',
        dataType: 'FONTKEY',
      },
    ]
  }

}