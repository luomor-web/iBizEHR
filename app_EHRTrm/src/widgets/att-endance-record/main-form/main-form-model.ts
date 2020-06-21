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
        prop: 'attendancerecordid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'attendancerecordname',
        dataType: 'TEXT',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'dkfs',
        prop: 'dkfs',
        dataType: 'SSCODELIST',
      },
      {
        name: 'attenddate',
        prop: 'attenddate',
        dataType: 'DATE',
      },
      {
        name: 'dksjqd',
        prop: 'dksjqd',
        dataType: 'DATETIME',
      },
      {
        name: 'dksjqt',
        prop: 'dksjqt',
        dataType: 'DATETIME',
      },
      {
        name: 'ormbmkqdzname',
        prop: 'ormbmkqdzname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormbmkqdzid',
        prop: 'ormbmkqdzid',
        dataType: 'PICKUP',
      },
      {
        name: 'attendancerecordid',
        prop: 'attendancerecordid',
        dataType: 'GUID',
      },
      {
        name: 'attendancerecord',
        prop: 'attendancerecordid',
        dataType: 'FONTKEY',
      },
    ]
  }

}